package com.bruxelles.bookitout.models.entities;

import com.bruxelles.bookitout.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Uzer{

    //BADGE IS GIVEN CONSIDERING THE NUMBER OF TIME YOU BOOK IN THE WEBSITE:
    //0 -> 4 = NOVICE
    //5 -> 9 = MEDIOR
    //  > 10 = RESTAURANT EXPERT
    @Column(name = "badge")
    private Status badge;



}
