import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from '../_services/token-storage.service';
import {CartService} from '../service/cart.service';
import {DataService} from '../service/data.service';
import {FacebookLoginProvider, GoogleLoginProvider, SocialAuthService, SocialUser} from 'angularx-social-login';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private roles: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username: string;

  public totalQuantity = 0;
  user: any;
  usernameSocial: string;
  socialUser: SocialUser;

  constructor(private tokenStorageService: TokenStorageService,
              private cartService: CartService,
              private dataService: DataService,
              private socialAuthService: SocialAuthService,
              private toast: ToastrService) {
  }

  ngOnInit() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    console.log(this.isLoggedIn);
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');

      this.username = user.username;
    }

    this.dataService.getData.subscribe((result: any) => {
      this.totalQuantity = parseInt(result.quantity, 10);
    });
    // this.cartService.getBooks().subscribe(res => {
    //   this.totalItem = res.length;
    // });
  }


  logout() {
    this.tokenStorageService.signOut();
    window.location.reload();
  }

  signInByFacebook() {
    this.socialAuthService.signIn(FacebookLoginProvider.PROVIDER_ID).then(data => {
      this.socialUser = data;
      this.isLoggedIn = (data != null);
      this.usernameSocial = this.socialUser.name;
      // const user: { password: string; email: string; username: string } = {
      //   email: data.email,
      //   password: data.id,
      //   username: data.name,
      // };
    });

  }

  signInWithGoogle() {
    this.socialAuthService.signIn(GoogleLoginProvider.PROVIDER_ID).then(data => {
      this.socialUser = data;
      this.isLoggedIn = (data != null);
      this.usernameSocial = this.socialUser.name;
      console.log(data);
    });
  }
}
