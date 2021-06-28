import { Joueur } from './joueur';
import { Rencontre } from './rencontre';
export class Inscription{
  constructor(
    private _joueur: Joueur | any = null,
    private _rencontre: Rencontre | any = null,
    private _placesReservees: number = 0
  ){}


    /**
     * Getter joueur
     * @return {joueur }
     */
	public get joueur(): Joueur  {
		return this._joueur;
	}

    /**
     * Getter rencontre
     * @return {rencontre }
     */
	public get rencontre(): Rencontre  {
		return this._rencontre;
	}

    /**
     * Setter joueur
     * @param {joueur } value
     */
	public set joueur(value: Joueur ) {
		this._joueur = value;
	}

    /**
     * Setter rencontre
     * @param {rencontre } value
     */
	public set rencontre(value: Rencontre ) {
		this._rencontre = value;
	}


    /**
     * Getter placesReservees
     * @return {number }
     */
	public get placesReservees(): number  {
		return this._placesReservees;
	}

    /**
     * Setter placesReservees
     * @param {number } value
     */
	public set placesReservees(value: number ) {
		this._placesReservees = value;
	}


}
