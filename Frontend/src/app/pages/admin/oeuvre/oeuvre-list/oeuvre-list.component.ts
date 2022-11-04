import { Component, OnInit } from '@angular/core';
import { OeuvreService } from 'src/app/services/Oeuvre/oeuvre.service';;


@Component({
  selector: 'app-oeuvre-list',
  templateUrl: './oeuvre-list.component.html',
  styleUrls: ['./oeuvre-list.component.css']
})
export class OeuvreListComponent implements OnInit {

  public errorMsg: string = "";

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

  constructor(private oeuvreService : OeuvreService) { }

  ngOnInit(): void {
    this.getOeuvreList();
  }

  deleteOeuvre(id : number){
    this.oeuvreService.deleteOeuvre(id).subscribe(
      (data : any) => {
        console.log(data);
        window.location.reload();
      },

      (error) => {
        console.log(error);
      }

    );
  }


  getOeuvreList() {
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


