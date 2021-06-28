import { Joueur } from './joueur';

export class Equipe {
  private _joueurs: Joueur[] = [];

  constructor(private _id: number = 0, private _name: string = '') {}

  /**
   * Getter joueurs
   * @return {Joueur[] }
   */
  public get joueurs(): Joueur[] {
    return this._joueurs;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number {
    return this._id;
  }

  /**
   * Getter name
   * @return {string }
   */
  public get name(): string {
    return this._name;
  }

  /**
   * Setter joueurs
   * @param {Joueur[] } value
   */
  public set joueurs(value: Joueur[]) {
    this._joueurs = value;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number) {
    this._id = value;
  }

  /**
   * Setter name
   * @param {string } value
   */
  public set name(value: string) {
    this._name = value;
  }
}
