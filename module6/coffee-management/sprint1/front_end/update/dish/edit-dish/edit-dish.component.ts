import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Dish} from "../model/dish";
import {DishType} from "../model/dish-type";
import {DishService} from "../service/dish.service";
import {DishTypeService} from "../service/dish-type.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {AngularFireStorage} from "@angular/fire/storage";
import {finalize} from "rxjs/operators";
import {formatDate} from "@angular/common";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-edit-dish',
  templateUrl: './edit-dish.component.html',
  styleUrls: ['./edit-dish.component.css']
})
export class EditDishComponent implements OnInit {
  formDish: FormGroup;
  id: number;
  dish: Dish;
  dishTypeList: DishType[] = [];
  selectedImage: any = null;
  imgSrc: any;
  dishList: Dish[] = [];
  currentImg: number;

  constructor(private dishService: DishService,
              private dishTypeService: DishTypeService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private storage: AngularFireStorage,
              private toastrService: ToastrService) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getDish(this.id);
    }, error => {
      console.log(error)
    }, () => {

    });
  }

  ngOnInit(): void {
    this.getAllDishType();
    this.getAllDishList();

    this.compareDishType(this.dish.dishType,this.dish.dishType);

  }

  getAllDishType() {
    this.dishTypeService.getAll().subscribe((data) => {
      this.dishTypeList = data;
    });
  }

  getAllDishList() {
    this.dishService.getAll().subscribe(data => {
      this.dishList = data;
    });
  }

  private getDish(id: number) {
    return this.dishService.findById(id).subscribe(data => {
      this.dish = data;
    }, error => {
    }, () => {
      this.currentImg = this.dish.dishType.id;
      this.formDish = new FormGroup({
        id: new FormControl(this.dish.id,),
        code: new FormControl(this.dish.code,[Validators.required, Validators.minLength(3)]),
        price: new FormControl(this.dish.price,[Validators.required,Validators.min(5000)] ),
        name: new FormControl(this.dish.name,[Validators.required, Validators.minLength(5)]),
        image: new FormControl(this.dish.image,[Validators.required]),
        isDeleted: new FormControl(this.dish.isDeleted),
        dishType: new FormControl(this.dish.dishType.name,[Validators.required]),
        creationDate: new FormControl(this.dish.creationDate),
      });
    });
  }

  EditDish(id: number) {
    if (this.selectedImage == null) {
      let dish: Dish = this.formDish.value;
      this.dishService.editDish(id, dish).subscribe((data) => {

          this.router.navigateByUrl('/dish').then();
          this.toastrService.success("Thành Công","Sửa")
        },
        error => {
          console.log(error);
        });
    } else {
      const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
      const fileRef = this.storage.ref(nameImg);
      this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
        finalize(() => {
          fileRef.getDownloadURL().subscribe((url) => {
            let dish: Dish = this.formDish.value;
            dish.image = url;

            this.dishService.editDish(id, dish).subscribe((data) => {

                this.router.navigateByUrl('/dish').then();
                this.toastrService.success("Thành Công","Sửa")
              },
              error => {
                console.log(error);
              });

          });
        })
      ).subscribe();
    }
  }

  showPreview(event: any) {
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      reader.onload = (o: any) => this.imgSrc = o.target.result;
      reader.readAsDataURL(event.target.files[0]);
      this.selectedImage = event.target.files[0];
      document.getElementById("image").style.display= "none"
      document.getElementById("img").style.display = "block"


    } else {
      this.imgSrc = "";
      this.selectedImage = null;
    }
  }

  private getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-YYY', 'en-US');
  }


  resetForm() {
    this.formDish.reset();
    document.getElementById("img").style.display = "none";
    document.getElementById("image").style.display = "none";

    const check: string = document.getElementById("opt").getAttribute("selected");
    if (check != "true") {
      document.getElementById("opt").setAttribute("selected", "true");
      document.getElementById("opt").setAttribute("disabled", "true");
    } else {
      document.getElementById("opt").removeAttribute("selected");
      document.getElementById("opt").removeAttribute("disabled");

      document.getElementById("opt").setAttribute("selected", "true");
      document.getElementById("opt").setAttribute("disabled", "true");
    }

  }

  compareDishType(o1: DishType, o2: DishType): boolean {
    if (o1 != null && o2 != null) {
      return o1.id == o2.id;
    }
  }



}
