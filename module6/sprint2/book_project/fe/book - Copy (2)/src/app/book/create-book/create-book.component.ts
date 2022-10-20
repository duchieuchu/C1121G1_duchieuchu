import {Component, OnInit} from '@angular/core';
import {Book} from '../../model/book';
import {Category} from '../../model/category';
import {FormControl, FormGroup} from '@angular/forms';
import {BookService} from '../../service/book.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {AngularFireStorage} from '@angular/fire/storage';
import {formatDate} from '@angular/common';
import {finalize} from 'rxjs/operators';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {
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
    bookName: new FormControl(''),
    description: new FormControl(''),
    price: new FormControl(''),
    image: new FormControl(''),
    pageNumber: new FormControl(''),
    authors: new FormControl(''),
    publishingHouse: new FormControl(''),
    quantity: new FormControl(''),
    category: new FormControl(''),
    isDeleted: new FormControl(false),
  });

  constructor(private bookService: BookService,
              private  router: Router,
              private toast: ToastrService,
              private storage: AngularFireStorage) {
  }

  ngOnInit(): void {
    this.getAllCategory();
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

  createBook() {
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
          };
          console.log(book);
          this.bookService.createBook(this.formBook.value).subscribe(data => {

          }, error => {

          }, () => {
            this.router.navigateByUrl('book/management').then(r => this.toast.success('Thêm mới thành công.', 'Thông Báo'));
          });
        });
      })
    ).subscribe();
  }


  // createBook() {
  //
  //   this.bookService.createBook(this.formBook.value).subscribe(data => {
  //
  //   }, error => {
  //
  //   }, () => {
  //     this.router.navigateByUrl('book/management').then(r => this.toast.success('Thêm mới thành công.', 'Thông Báo'));
  //   });
  // }

  getAllCategory() {
    this.bookService.getAllCategory().subscribe((data) => {
      this.categoryArray = data;
    }, error => {
    }, () => {
      console.log(this.categoryArray);
    });
  }

}
