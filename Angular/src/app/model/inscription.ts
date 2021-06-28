import { Joueur } from './joueur';
import { Rencontre } from './rencontre';

export class Inscription {
  constructor(
    private _joueur: Joueur | any = null,
    private _rencontre: Rencontre | any = null,
    private _placesReservées: number = 0
  ) {}

  /**
   * Getter joueur
   * @return {Joueur }
   */
  public get joueur(): Joueur {
    return this._joueur;
  }

  /**
   * Getter rencontre
   * @return {Rencontre }
   */
  public get rencontre(): Rencontre {
    return this._rencontre;
  }

  /**
   * Setter joueur
   * @param {Joueur } value
   */
  public set joueur(value: Joueur) {
    this._joueur = value;
  }

  /**
   * Setter rencontre
   * @param {Rencontre } value
   */
  public set rencontre(value: Rencontre) {
    this._rencontre = value;
  }
}
