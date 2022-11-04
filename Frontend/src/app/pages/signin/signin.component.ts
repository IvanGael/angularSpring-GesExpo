import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/User/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  public loginForm : FormGroup = new FormGroup({});

  constructor(private authService : AuthService, private fb: FormBuilder, private router : Router) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username : ['',Validators.required],
      password : ['', Validators.required]
    })
  }

  login(){
    this.authService.authenticate(this.loginForm.value).subscribe(
      (data) => {
        console.log(data);
      },

      (error) => {
        console.log(error);
      }
    );
  }

}
