import {Component, OnInit} from '@angular/core';
import {Word} from '../model/word';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {DictionaryService} from '../service/dictionary.service';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  word: Word[] = [];

  constructor(private activatedRoute: ActivatedRoute, private service: DictionaryService) {
    activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const info = paramMap.get('word');
      this.word = service.dictionary.filter((word) => word.word === info);
    });
  }

  ngOnInit(): void {
  }

}
