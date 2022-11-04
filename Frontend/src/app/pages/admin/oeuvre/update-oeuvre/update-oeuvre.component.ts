import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Oeuvre } from 'src/app/models/oeuvre';
import { OeuvreService } from 'src/app/services/Oeuvre/oeuvre.service';

@Component({
  selector: 'app-update-oeuvre',
  templateUrl: './update-oeuvre.component.html',
  styleUrls: ['./update-oeuvre.component.css']
})
export class UpdateOeuvreComponent implements OnInit {

  public oeuvre : Oeuvre = {
    id: 0,
    titre: '',
    annee: 0,
    prix: 0,
    rating: '',
    type: '',
    image: ''
  }

  public updateOeuvreForm : FormGroup = new FormGroup({});

  constructor(private route: ActivatedRoute, private oeuvreService : OeuvreService, private fb: FormBuilder, private router : Router) { }

  ngOnInit(): void {
    this.updateOeuvreForm = this.fb.group({
      titre : ['', [Validators.required, Validators.minLength(4)]],
      annee : ['', Validators.required],
      prix : ['', Validators.required],
      rating : ['', Validators.required],
      type : ['', Validators.required]
    });

    this.fillInput();
    
    
  }

  fillInput() {
    const id = Number(this.route.snapshot.paramMap.get('oeuvreId'))!;
    this.oeuvreService.getOeuvreById(id).subscribe(
      (data : any) => {
        this.oeuvre = data
        this.updateOeuvreForm.patchValue({
          titre : this.oeuvre.titre,
          annee : this.oeuvre.annee,
          prix : this.oeuvre.prix,
          rating : this.oeuvre.rating,
          type : this.oeuvre.type
        });
        console.log(data);
      },

      (error) => {
        console.log(error);
      }

    );
  }


  updateOeuvre() {
    const id = Number(this.route.snapshot.paramMap.get('oeuvreId'))!;
    this.oeuvreService.updateOeuvre(this.updateOeuvreForm.value, id).subscribe(
      (data : any) => {
        console.log(data);
        this.router.navigate(['/admin/oeuvre/all']);
      },

      (error : any) => {
        console.log(error);
      }

    );
  }

}
