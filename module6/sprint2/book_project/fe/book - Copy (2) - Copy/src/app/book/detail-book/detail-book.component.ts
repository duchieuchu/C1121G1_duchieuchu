import {Component, OnInit} from '@angular/core';
import {BookService} from '../../service/book.service';
import {Book} from '../../model/book';
import {Title} from '@angular/platform-browser';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-detail-book',
  templateUrl: './detail-book.component.html',
  styleUrls: ['./detail-book.component.css']
})
export class DetailBookComponent implements OnInit {
  public book: Book;


  constructor(private bookService: BookService,
              private title: Title,
              private activatedRoute: ActivatedRoute,
              private toast: ToastrService,
              private router: Router) {
    this.title.setTitle('Chi tiết sách');
  }

  ngOnInit(): void {
    this.getParamId();
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

      });
    });
  }


}
