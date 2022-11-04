import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Oeuvre } from 'src/app/models/oeuvre';
import { OeuvreService } from 'src/app/services/Oeuvre/oeuvre.service'

@Component({
  selector: 'app-oeuvre-detail',
  templateUrl: './oeuvre-detail.component.html',
  styleUrls: ['./oeuvre-detail.component.css']
})
export class OeuvreDetailComponent implements OnInit {

  public oeuvre : Oeuvre = {
    id: 0,
    titre: '',
    annee: 0,
    prix: 0,
    rating: '',
    type: '',
    image: ''
  }

  constructor(private route: ActivatedRoute, private oeuvreService : OeuvreService) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('oeuvreId'))!;
    this.oeuvreService.getOeuvreById(id).subscribe(
      (data : any) => {
        this.oeuvre = data
        console.log(data);
      },

      (error) => {
        console.log(error);
      }

    );

    this.oeuvreService.getOeuvreImage(id).subscribe(
      (data : any) => {
        console.log(data);
      },

      (error) => {
        console.log(error);
      }

    );
  }

}
