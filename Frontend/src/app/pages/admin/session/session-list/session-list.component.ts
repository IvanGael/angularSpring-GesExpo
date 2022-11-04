import { Component, OnInit } from '@angular/core';
import { SessionService } from 'src/app/services/Session/session.service';

@Component({
  selector: 'app-session-list',
  templateUrl: './session-list.component.html',
  styleUrls: ['./session-list.component.css']
})
export class SessionListComponent implements OnInit {

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

  constructor(private sessionService : SessionService) { }

  ngOnInit(): void {
    this.getSessionList();
  }


  deleteSession(id : number){
    this.sessionService.deleteSession(id).subscribe(
      (data : any) => {
        console.log(data);
        window.location.reload();
      },

      (error) => {
        console.log(error);
      }

    );
  }


  getSessionList() {
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

}
