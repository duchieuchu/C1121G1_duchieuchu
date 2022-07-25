import {Component, OnInit} from '@angular/core';
import {Word} from '../model/word';
import {DictionaryService} from '../service/dictionary.service';

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
  library: Word[] = [];

  constructor(private service: DictionaryService) {
    this.library = this.service.getAll();
  }

  ngOnInit(): void {
  }

}
