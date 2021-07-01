import { Joueur } from './joueur';
import { Rencontre } from './rencontre';
export class Inscription {
  constructor(
    private _joueur: Joueur | any = null,
    private _nbPlaces: number = 0
  ) {}

  /**
   * Getter joueur
   * @return {joueur }
   */
  public get joueur(): Joueur {
    return this._joueur;
  }

  /**
   * Setter joueur
   * @param {joueur } value
   */
  public set joueur(value: Joueur) {
    this._joueur = value;
  }

  /**
   * Getter nbPlaces
   * @return {number }
   */
  public get nbPlaces(): number {
    return this._nbPlaces;
  }

  /**
   * Setter nbPlaces
   * @param {number } value
   */
  public set nbPlaces(value: number) {
    this._nbPlaces = value;
  }
}
