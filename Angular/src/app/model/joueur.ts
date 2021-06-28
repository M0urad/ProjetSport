export class Joueur {
  constructor(
    private _id: number = 0,
    private _nom: String = '',
    private _prenom: String = '',
    private _numTel: number = 0,
    private _poste: String = '',
    private _compte: Compte = null
  ) {}

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number {
    return this._id;
  }

  /**
   * Getter nom
   * @return {String }
   */
  public get nom(): String {
    return this._nom;
  }

  /**
   * Getter prenom
   * @return {String }
   */
  public get prenom(): String {
    return this._prenom;
  }

  /**
   * Getter numTel
   * @return {number }
   */
  public get numTel(): number {
    return this._numTel;
  }

  /**
   * Getter poste
   * @return {String }
   */
  public get poste(): String {
    return this._poste;
  }

  /**
   * Getter compte
   * @return {Compte }
   */
  public get compte(): Compte {
    return this._compte;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number) {
    this._id = value;
  }

  /**
   * Setter nom
   * @param {String } value
   */
  public set nom(value: String) {
    this._nom = value;
  }

  /**
   * Setter prenom
   * @param {String } value
   */
  public set prenom(value: String) {
    this._prenom = value;
  }

  /**
   * Setter numTel
   * @param {number } value
   */
  public set numTel(value: number) {
    this._numTel = value;
  }

  /**
   * Setter poste
   * @param {String } value
   */
  public set poste(value: String) {
    this._poste = value;
  }

  /**
   * Setter compte
   * @param {Compte } value
   */
  public set compte(value: Compte) {
    this._compte = value;
  }
}
