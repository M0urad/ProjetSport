import { NumberSymbol } from "@angular/common";

export class Rencontre {

  constructor(private id:number | any = null,
    private _nom:string='',
    private _date:Date | any = null,
    private _lieu:Lieu | any = null,
    private _equipes:Equipe[] | any = null,
    private _nbPlaces:number | any = null,
    private _inscriptions: Inscription[] | any = null,
    private _proprio:Joueur | any = null,
    private _messages:Message[] | any = null
    ){}


    /**
     * Getter $id
     * @return {number }
     */
	public get $id(): number  {
		return this.id;
	}

    /**
     * Getter nom
     * @return {string}
     */
	public get nom(): string {
		return this._nom;
	}

    /**
     * Getter date
     * @return {Date }
     */
	public get date(): Date  {
		return this._date;
	}

    /**
     * Getter lieu
     * @return {Lieu }
     */
	public get lieu(): Lieu  {
		return this._lieu;
	}

    /**
     * Getter equipes
     * @return {Equipe[] }
     */
	public get equipes(): Equipe[]  {
		return this._equipes;
	}

    /**
     * Getter nbPlaces
     * @return {number }
     */
	public get nbPlaces(): number  {
		return this._nbPlaces;
	}

    /**
     * Getter inscriptions
     * @return {Inscription[] }
     */
	public get inscriptions(): Inscription[]  {
		return this._inscriptions;
	}

    /**
     * Getter proprio
     * @return {Joueur }
     */
	public get proprio(): Joueur  {
		return this._proprio;
	}

    /**
     * Getter messages
     * @return {Message[] }
     */
	public get messages(): Message[]  {
		return this._messages;
	}

    /**
     * Setter $id
     * @param {number } value
     */
	public set $id(value: number ) {
		this.id = value;
	}

    /**
     * Setter nom
     * @param {string} value
     */
	public set nom(value: string) {
		this._nom = value;
	}

    /**
     * Setter date
     * @param {Date } value
     */
	public set date(value: Date ) {
		this._date = value;
	}

    /**
     * Setter lieu
     * @param {Lieu } value
     */
	public set lieu(value: Lieu ) {
		this._lieu = value;
	}

    /**
     * Setter equipes
     * @param {Equipe[] } value
     */
	public set equipes(value: Equipe[] ) {
		this._equipes = value;
	}

    /**
     * Setter nbPlaces
     * @param {number } value
     */
	public set nbPlaces(value: number ) {
		this._nbPlaces = value;
	}

    /**
     * Setter inscriptions
     * @param {Inscription[] } value
     */
	public set inscriptions(value: Inscription[] ) {
		this._inscriptions = value;
	}

    /**
     * Setter proprio
     * @param {Joueur } value
     */
	public set proprio(value: Joueur ) {
		this._proprio = value;
	}

    /**
     * Setter messages
     * @param {Message[] } value
     */
	public set messages(value: Message[] ) {
		this._messages = value;
	}


}
