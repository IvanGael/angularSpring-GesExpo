import { Component, OnInit } from '@angular/core';
import { ExpositionService } from 'src/app/services/Exposition/exposition.service';

@Component({
  selector: 'app-exposition-list',
  templateUrl: './exposition-list.component.html',
  styleUrls: ['./exposition-list.component.css']
})
export class ExpositionListComponent implements OnInit {

  expositions = [
    {
      id: 1,
      titre: "mon chef d'oeuvre",
      etat: 2022,
      dateExpo: 150000,
      duree: "Amateur",
    },
    {
      id: 2,
      titre: "mon chef d'oeuvre",
      annee: 2022,
      prix: 150000,
      rating: "Amateur",
    }
  ]

  constructor(private expoService : ExpositionService) { }

  ngOnInit(): void {
    this.getExpoList();
  }


  deleteExpo(id : number){
    this.expoService.deleteExpo(id).subscribe(
      (data : any) => {
        console.log(data);
        window.location.reload();
      },

      (error) => {
        console.log(error);
      }

    );
  }

  getExpoList() {
    this.expoService.getExpoList().subscribe(
      (data : any) => {
        this.expositions = data;
        console.log(this.expositions);
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
