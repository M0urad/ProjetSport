import { Compte } from './compte';
import { Role } from './role';

export class Joueur extends Compte {
  constructor(
    id?: number,
    username?: string,
    password?: string,
    role?: Role,
    mail?: string,
    private _nom: string = '',
    private _prenom: string = '',
    private _numTel: number | any = null
  ) {
    super(id, username, password, role, mail);
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string {
    return this._nom;
  }

  /**
   * Getter prenom
   * @return {string }
   */
  public get prenom(): string {
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
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string) {
    this._nom = value;
  }

  /**
   * Setter prenom
   * @param {string } value
   */
  public set prenom(value: string) {
    this._prenom = value;
  }

  /**
   * Setter numTel
   * @param {number } value
   */
  public set numTel(value: number) {
    this._numTel = value;
  }
}
