import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import {Observable} from 'rxjs';
import {AuthService} from '../_services/auth.service';
import {ToastrService} from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router,
              private authService: AuthService,
              private toast: ToastrService) {
  }

  canActivate() {
    if (this.authService.isLogIn()) {
      if (this.authService.isAdminLoggedIn()) {
        return true;
      } else {
        this.router.navigateByUrl('/error403').then(() => {
          this.toast.error('Bạn không có quyền truy cập.', 'Thông báo');
        });
        return false;
      }
      if (this.authService.isUserLoggedIn()) {
        this.router.navigateByUrl('/error403').then(() => {
          this.toast.error('Bạn không có quyền truy cập.', 'Thông báo');
        });
      }
    }
    this.router.navigateByUrl('/error401').then(() => {
      this.toast.error('Vui lòng đăng nhập.', 'Thông báo');
    });
    return false;

  }
}
