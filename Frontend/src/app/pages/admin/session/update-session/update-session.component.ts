import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Session } from 'src/app/models/session';
import { SessionService } from 'src/app/services/Session/session.service';

@Component({
  selector: 'app-update-session',
  templateUrl: './update-session.component.html',
  styleUrls: ['./update-session.component.css']
})
export class UpdateSessionComponent implements OnInit {

  public session : Session = {
    id: 0,
    titre: '',
    dateDebut: new Date(),
    dateFin: new Date(),
    localisation: ''
  }

  public updateSessionForm : FormGroup = new FormGroup({});

  constructor(private route: ActivatedRoute, private sessionService : SessionService, private router : Router, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.updateSessionForm = this.fb.group({
      titre : ['', [Validators.required, Validators.minLength(4)]],
      dateDebut : ['', Validators.required],
      dateFin : [''],
      localisation : ['', Validators.required]
    })

    this.fillInput();
  }

  fillInput (){
    const id = Number(this.route.snapshot.paramMap.get('sessionId'))!;
    this.sessionService.getSessionById(id).subscribe(
      (data : any) => {
        this.session = data
        this.updateSessionForm.patchValue({
          titre : this.session.titre,
          dateDebut : this.session.dateDebut,
          dateFin : this.session.dateFin,
          localisation : this.session.localisation
        });
        console.log(data);
      },

      (error) => {
        console.log(error);
      }
    )
  }



  updateSession() {
    const id = Number(this.route.snapshot.paramMap.get('sessionId'))!;
    this.sessionService.updateSession(this.updateSessionForm.value, id).subscribe(
      (data : any) => {
        console.log(data);
        this.router.navigate(['/admin/session/all']);
      },

      (error : any) => {
        console.log(error);
      }

    );
  }

}
