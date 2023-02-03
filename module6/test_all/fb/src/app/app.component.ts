import {Component} from '@angular/core';
// @ts-ignore
import {ApiService} from './services/api.service';
// @ts-ignore
import {AngularFireStorage} from '@angular/fire/storage';
import {map, finalize} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'cloudsSorage';
  selectedFile: File = null;
  fb;
  downloadURL: Observable<string>;

  formPigsty = new FormGroup({
    buildDate: new FormControl(),
    code: new FormControl(),
    creationDate: new FormControl(),
    maxNumber: new FormControl(),
    typePigs: new FormControl(),
    employee: new FormControl(),
  });


  constructor(private storage: AngularFireStorage) {
  }

  onFileSelected(event) {
    var n = Date.now();
    const file = event.target.files[0];
    const filePath = `RoomsImages/${n}`;
    const fileRef = this.storage.ref(filePath);
    const task = this.storage.upload(`RoomsImages/${n}`, file);
    task
      .snapshotChanges()
      .pipe(
        finalize(() => {
          this.downloadURL = fileRef.getDownloadURL();
          this.downloadURL.subscribe(url => {
            if (url) {
              this.fb = url;
            }
            console.log(this.fb);
          });
        })
      )
      .subscribe(url => {
        if (url) {
          console.log(url);
        }
      });
  }


}
