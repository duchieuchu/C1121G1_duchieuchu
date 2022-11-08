import {Component, OnInit} from '@angular/core';
import {Title} from '@angular/platform-browser';
import {BookService} from '../../service/book.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {AngularFireStorage} from '@angular/fire/storage';
import {formatDate} from '@angular/common';
import {Book} from '../../model/book';
import {finalize} from 'rxjs/operators';
import {Category} from '../../model/category';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css']
})
export class EditBookComponent implements OnInit {
  book: Book;
  categoryArray: Category[] = [];

  selectedImage: File = null;
  checkImgSize = false;
  regexImageUrl = false;
  editImageState = false;
  checkImg: boolean;
  url: any;
  msg = '';


  formBook = new FormGroup({
    bookName: new FormControl('', Validators.required),
    description: new FormControl('', Validators.required),
    price: new FormControl('', Validators.required),
    image: new FormControl('', Validators.required),
    pageNumber: new FormControl('', Validators.required),
    authors: new FormControl('', Validators.required),
    publishingHouse: new FormControl('', Validators.required),
    quantity: new FormControl('', Validators.required),
    category: new FormControl('', Validators.required),
    isDeleted: new FormControl(false),
  });

  constructor(private title: Title,
              private bookService: BookService,
              private  router: Router,
              private toast: ToastrService,
              private storage: AngularFireStorage,
              private activatedRoute: ActivatedRoute) {
    this.title.setTitle('Chỉnh sửa sách');
  }

  ngOnInit(): void {
    this.getAllCategory();
    this.getParamId();
  }

  compareCategory(object1: Category, object2: Category): boolean {
    return object1.id === object2.id;
  }

  getParamId() {
    this.activatedRoute.paramMap.subscribe((paraMap: ParamMap) => {
      const id = paraMap.get('id');
      this.bookService.getBookById(+id).subscribe(data => {
        if (data == null) {
          this.toast.error('Thao tác của bạn không đúng nên đã quay lại danh sách.', 'Thông Báo');
          this.router.navigateByUrl('/book/management').then();
        }
        this.book = data;
        this.getForm(this.book);
      });
    });
  }

  getForm(book: Book) {
    this.formBook = new FormGroup({
      id: new FormControl(book.id, Validators.required),
      bookName: new FormControl(book.bookName, Validators.required),
      description: new FormControl(book.description, Validators.required),
      price: new FormControl(book.price, Validators.required),
      image: new FormControl(book.image, Validators.required),
      pageNumber: new FormControl(book.pageNumber, Validators.required),
      authors: new FormControl(book.authors, Validators.required),
      publishingHouse: new FormControl(book.publishingHouse, Validators.required),
      quantity: new FormControl(book.quantity, Validators.required),
      category: new FormControl(book.category, Validators.required),
      isDeleted: new FormControl(false),
    });
    // this.formBook.patchValue(book);
  }

  getCurrentDateTime(): string {
    return formatDate(new Date(), 'yyyy-MM-dd hh:mm:ss', 'en-US');
  }

  onFileSelected(event) {
    this.regexImageUrl = false;
    if (event.target.files[0].size > 9000000) {
      return;
    }
    this.selectedImage = event.target.files[0];
    if (!event.target.files[0].name.match('^.*\\.(jpg|JPG)$')) {
      this.regexImageUrl = true;
      return;
    }
    this.formBook.patchValue({imageUrl: this.selectedImage.name});
  }

  selectFile(event: any) {
    if (!event.target.files[0] || event.target.files[0].length === 0) {
      return;
    }
    if (event.target.files[0].size > 9000000) {
      return;
    }
    if (!event.target.files[0].name.match('^.*\\.(jpg|JPG)$')) {
      return;
    }
    this.checkImgSize = false;
    this.checkImg = false;
    this.editImageState = true;

    const mimeType = event.target.files[0].type;

    if (mimeType.match(/image\/*/) == null) {
      this.msg = 'Chỉ có file ảnh được hỗ trợ';
      return;
    }
    const reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);

    // tslint:disable-next-line:variable-name
    reader.onload = (_event) => {
      this.msg = '';
      this.url = reader.result;
    };
  }

  editBook() {
    const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
    const filePath = `book/${nameImg}`;
    const fileRef = this.storage.ref(filePath);
    let book: Book;


    this.storage.upload(filePath, this.selectedImage).snapshotChanges().pipe(finalize(() => {
        fileRef.getDownloadURL().subscribe((url) => {
          this.formBook.patchValue({image: url});
          book = {
            id: this.formBook.value.id,
            bookName: this.formBook.value.bookName,
            description: this.formBook.value.description,
            price: this.formBook.value.price,
            image: this.formBook.value.image,
            pageNumber: this.formBook.value.pageNumber,
            authors: this.formBook.value.authors,
            publishingHouse: this.formBook.value.publishingHouse,
            quantity: this.formBook.value.quantity,
            category: this.formBook.value.category,
            isDeleted: this.formBook.value.isDeleted,
          };
          console.log(book);
          this.bookService.editBook(this.formBook.value).subscribe(data => {

          }, error => {

          }, () => {
            this.router.navigateByUrl('book/management').then(r => this.toast.success('Chỉnh sửa thành công.', 'Thông Báo'));
          });
        });
      })
    ).subscribe();
  }

  getAllCategory() {
    this.bookService.getAllCategory().subscribe((data) => {
      this.categoryArray = data;
    }, error => {
    }, () => {
      console.log(this.categoryArray);
    });
  }

}
