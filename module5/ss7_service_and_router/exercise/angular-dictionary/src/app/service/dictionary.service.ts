import {Injectable} from '@angular/core';
import {Word} from '../model/word';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionary: Word[] = [];

  constructor() {
    this.dictionary.push({word: 'computer', mean: 'may tinh'});
    this.dictionary.push({word: 'bamboo', mean: 'cay tre'});
    this.dictionary.push({word: 'computer', mean: 'may tinh'});
    this.dictionary.push({word: 'distance', mean: 'khoang cach'});
    this.dictionary.push({word: 'rubber', mean: 'cuc tay'});
    this.dictionary.push({word: 'mouse', mean: 'may tinh'});
    this.dictionary.push({word: 'chicken', mean: 'con ga'});
    this.dictionary.push({word: 'passport', mean: 'ho chieu'});
  }

  getAll(): Word[] {
    return this.dictionary;
  }
}
