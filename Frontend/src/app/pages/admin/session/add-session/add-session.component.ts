import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OeuvreService } from 'src/app/services/Oeuvre/oeuvre.service';
import { Router } from '@angular/router';
import { SessionService } from 'src/app/services/Session/session.service';

@Component({
  selector: 'app-add-session',
  templateUrl: './add-session.component.html',
  styleUrls: ['./add-session.component.css']
})
export class AddSessionComponent implements OnInit {

  public errorMsg: string = "";
  public successMsg : string  = "";

  public addSessionForm : FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder, private sessionService : SessionService, private router : Router) { }

  ngOnInit(): void {
    this.addSessionForm = this.fb.group({
      titre : ['', [Validators.required, Validators.minLength(4)]],
      dateDebut : ['', Validators.required],
      dateFin : [''],
      localisation : ['', Validators.required]
    })
  }


  addSession() {
    this.sessionService.addSession(this.addSessionForm.value).subscribe(
      (data) => {
        console.log(data);
        data != null ? this.successMsg = "Session ajouté avec succes!" : this.errorMsg = "Une erreur s'est produit"
        setTimeout(() => {
          this.router.navigate(['/admin/session/all']);
        }, 2000);
      },

      (error) => {
        console.log(error);
      }
    );
  }

}
