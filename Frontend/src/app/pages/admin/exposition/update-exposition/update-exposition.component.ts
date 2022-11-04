import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Exposition } from 'src/app/models/exposition';
import { ExpositionService } from 'src/app/services/Exposition/exposition.service';
import { OeuvreService } from 'src/app/services/Oeuvre/oeuvre.service';
import { SessionService } from 'src/app/services/Session/session.service';

@Component({
  selector: 'app-update-exposition',
  templateUrl: './update-exposition.component.html',
  styleUrls: ['./update-exposition.component.css']
})
export class UpdateExpositionComponent implements OnInit {

  public exposition : Exposition = {
    id: 0,
    titre: '',
    etat: 0,
    dateExpo: new Date(),
    duree: 0,
    oeuvreId: 0,
    sessionId: 0
  };

  public updateExpoForm : FormGroup = new FormGroup({});


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


  constructor(private route: ActivatedRoute, 
    private fb: FormBuilder, private router : Router, 
    private expoService : ExpositionService, private sessionService : SessionService, private oeuvreService : OeuvreService) { }

  ngOnInit(): void {
    this.updateExpoForm = this.fb.group({
      titre : ['', [Validators.required, Validators.minLength(4)]],
      etat : ['', Validators.required],
      dateExpo : ['', Validators.required],
      duree : ['', Validators.required],
      oeuvreId : ['',  Validators.required],
      sessionId : ['', Validators.required]
    })

    this.fillInput();
    this.getAllOeuvres();
    this.getAllSessions();
  }


  fillInput(){
    const id = Number(this.route.snapshot.paramMap.get('expoId'))!;
    this.expoService.getExpoById(id).subscribe(
      (data : any) => {
        this.exposition = data
        this.updateExpoForm.patchValue({
          titre : this.exposition.titre,
          etat : this.exposition.etat,
          dateExpo : this.exposition.dateExpo,
          duree : this.exposition.duree,
          oeuvreId : this.exposition.oeuvreId,
          sessionId : this.exposition.sessionId
        });
        console.log(data);
      },

      (error) => {
        console.log(error);
      }

    );
  }


  updateExpo(){
    const id = Number(this.route.snapshot.paramMap.get('expoId'))!;
    this.expoService.updateExpo(this.updateExpoForm.value, id).subscribe(
      (data : Exposition) => {
        console.log(data);
        this.router.navigate(['/admin/exposition/all']);
      },

      (error : any) => {
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
