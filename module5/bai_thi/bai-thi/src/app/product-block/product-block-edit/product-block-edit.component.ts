import {Component, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {ProductBlock} from '../../model/product-block';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ProductBlockService} from '../../service/product-block.service';

@Component({
  selector: 'app-product-block-edit',
  templateUrl: './product-block-edit.component.html',
  styleUrls: ['./product-block-edit.component.css']
})
export class ProductBlockEditComponent implements OnInit {
  editProductBlockFromGroup: FormGroup;
  productBlock: ProductBlock;
  idEditProduct: number;

  constructor(private activatedRoute: ActivatedRoute, private productBlockService: ProductBlockService, private router: Router) {
  }

  ngOnInit(): void {
    // this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
    //   this.idEditProduct = parseInt(param.get('id'));
    //   this.productBlockService.
    // });
    // this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
    //       this.idEditCustomer = parseInt(param.get('id'));
    //       this.customerService.getCustomerById(this.idEditCustomer).subscribe(customer => {
    //         this.editCustomerFormGroup = new FormGroup({
    //           id: new FormControl(customer.id),
    //           name: new FormControl(customer.name),
    //           birthday: new FormControl(customer.birthday),
    //           gender: new FormControl(customer.gender),
    //           idCard: new FormControl(customer.idCard),
    //           phone: new FormControl(customer.phone),
    //           email: new FormControl(customer.email),
    //           address: new FormControl(customer.address),
    //           customerType: new FormControl(customer.customerType)
    //         });
    //       });
    //     });
  }

}
