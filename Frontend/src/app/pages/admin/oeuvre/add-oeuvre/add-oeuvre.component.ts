import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OeuvreService } from 'src/app/services/Oeuvre/oeuvre.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-oeuvre',
  templateUrl: './add-oeuvre.component.html',
  styleUrls: ['./add-oeuvre.component.css']
})
export class AddOeuvreComponent implements OnInit {

  public errorMsg: string = "";
  public successMsg : string  = "";

  public addOeuvreForm : FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder, private oeuvreService : OeuvreService, private router : Router) { }

  

  ngOnInit(): void {
    this.addOeuvreForm = this.fb.group({
      titre : ['', [Validators.required, Validators.minLength(4)]],
      annee : ['', Validators.required],
      prix : ['', Validators.required],
      rating : ['', Validators.required],
      type : ['', Validators.required]
    });
  }



  addOeuvre() {
    // console.log(this.addOeuvreForm.value);
    this.oeuvreService.addOeuvre(this.addOeuvreForm.value).subscribe(
      (data) => {
        console.log(data);
        data != null ? this.successMsg = "Oeuvre ajouté avec succes!" : this.errorMsg = "Une erreur s'est produit"
        setTimeout(() => {
          //this.addOeuvreForm.reset();
          this.router.navigate(['/admin/oeuvre/all']);
        }, 2000);
      },

      (error) => {
        console.log(error);
      }
    );
    
  }

}
