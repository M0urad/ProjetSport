export class inscription{
  constructor(
    private _joueur: joueur = null,
    private _rencontre: rencontre = null,
    private _placesReservées: number = 0
  ){}


    /**
     * Getter joueur
     * @return {joueur }
     */
	public get joueur(): joueur  {
		return this._joueur;
	}

    /**
     * Getter rencontre
     * @return {rencontre }
     */
	public get rencontre(): rencontre  {
		return this._rencontre;
	}

    /**
     * Setter joueur
     * @param {joueur } value
     */
	public set joueur(value: joueur ) {
		this._joueur = value;
	}

    /**
     * Setter rencontre
     * @param {rencontre } value
     */
	public set rencontre(value: rencontre ) {
		this._rencontre = value;
	}

}
