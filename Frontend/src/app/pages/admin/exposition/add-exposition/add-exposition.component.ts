import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ExpositionService } from 'src/app/services/Exposition/exposition.service';
import { OeuvreService } from 'src/app/services/Oeuvre/oeuvre.service';
import { SessionService } from 'src/app/services/Session/session.service';

@Component({
  selector: 'app-add-exposition',
  templateUrl: './add-exposition.component.html',
  styleUrls: ['./add-exposition.component.css']
})
export class AddExpositionComponent implements OnInit {

  public errorMsg: string = "";
  public successMsg : string  = "";

  public addExpoForm : FormGroup = new FormGroup({});


  sessions = [
    {
      id: 1,
      titre: "session de juillet",
      dateDebut : "2021-07-15",
      localisation : "Lomé"
    },
    {
      id: 2,
      titre: "session de avril",
      dateDebut : "2021-04-25",
      localisation : "Lomé"
    }
  ];

  oeuvres = [
    {
      id: 1,
      titre: "mon chef d'oeuvre",
      annee: 2022,
      prix: 150000,
      rating: "Amateur",
    },
    {
      id: 2,
      titre: "mon chef d'oeuvre",
      annee: 2022,
      prix: 150000,
      rating: "Amateur",
    }
  ];


  constructor(private fb: FormBuilder, private expoService : ExpositionService, 
    private sessionService : SessionService, private oeuvreService : OeuvreService, private router : Router) { }

  ngOnInit(): void {
    this.addExpoForm = this.fb.group({
      titre : ['', [Validators.required, Validators.minLength(4)]],
      etat : ['', Validators.required],
      dateExpo : ['', Validators.required],
      duree : ['', Validators.required],
      oeuvreId : ['', Validators.required],
      sessionId : ['', Validators.required]
    })
    this.getAllOeuvres();
    this.getAllSessions();
  }



  addExpo() {
    this.expoService.addExpo(this.addExpoForm.value).subscribe(
      (data) => {
        console.log(data);
        data != null ? this.successMsg = "Exposition ajouté avec succes!" : this.errorMsg = "Une erreur s'est produit"
        setTimeout(() => {
          this.router.navigate(['/admin/exposition/all']);
        }, 2000);
      },

      (error) => {
        console.log(error);
      }
    );
  }


  getAllSessions(){
    this.sessionService.getSessionList().subscribe(
      (data : any) => {
        this.sessions = data;
        console.log(this.sessions);
      },

      (error) => {
        console.log(error);
      },

      () => {
        console.log("finished getting data!!")
      }

    )
  }


  getAllOeuvres(){
    this.oeuvreService.getOeuvreList().subscribe(
      (data : any) => {
        this.oeuvres = data;
        console.log(this.oeuvres);
      },

      (error) => {
        console.log(error);
      },

      () => {
        console.log("finished getting data!!")
      }

    )
  }

}
