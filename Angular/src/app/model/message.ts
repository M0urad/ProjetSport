import { Rencontre } from './rencontre';
export class Message {
  constructor(private _rencontre:Rencontre | any = null,
    private _commentaire:string=''){}


    /**
     * Getter rencontre
     * @return {Rencontre }
     */
	public get rencontre(): Rencontre  {
		return this._rencontre;
	}

    /**
     * Getter commentaire
     * @return {string}
     */
	public get commentaire(): string {
		return this._commentaire;
	}

    /**
     * Setter rencontre
     * @param {Rencontre } value
     */
	public set rencontre(value: Rencontre ) {
		this._rencontre = value;
	}

    /**
     * Setter commentaire
     * @param {string} value
     */
	public set commentaire(value: string) {
		this._commentaire = value;
	}

}
