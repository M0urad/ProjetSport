export class compte{
  constructor(
    private _nom: string ='',
    private _numero: number = 0,
    private _voie: string ='',
    private _ville: string = '',
    private _codePostal: string = ''
  ){}


      /**
       * Getter nom
       * @return {string }
       */
    public get nom(): string  {
      return this._nom;
    }

      /**
       * Getter numero
       * @return {number }
       */
    public get numero(): number  {
      return this._numero;
    }

      /**
       * Getter voie
       * @return {string }
       */
    public get voie(): string  {
      return this._voie;
    }

      /**
       * Getter ville
       * @return {string }
       */
    public get ville(): string  {
      return this._ville;
    }

      /**
       * Getter codePostal
       * @return {string }
       */
    public get codePostal(): string  {
      return this._codePostal;
    }

      /**
       * Setter nom
       * @param {string } value
       */
    public set nom(value: string ) {
      this._nom = value;
    }

      /**
       * Setter numero
       * @param {number } value
       */
    public set numero(value: number ) {
      this._numero = value;
    }

      /**
       * Setter voie
       * @param {string } value
       */
    public set voie(value: string ) {
      this._voie = value;
    }

      /**
       * Setter ville
       * @param {string } value
       */
    public set ville(value: string ) {
      this._ville = value;
    }

      /**
       * Setter codePostal
       * @param {string } value
       */
    public set codePostal(value: string ) {
      this._codePostal = value;
    }


  }
