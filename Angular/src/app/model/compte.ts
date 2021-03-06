import { Role } from './role';
export class Compte {
  constructor(
    private _id: number | any = null,
    private _username: string = '',
    private _password: string = '',
    private _role: Role | any = null,
    private _mail: string = ''
  ) {}

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number {
    return this._id;
  }

  /**
   * Getter username
   * @return {string }
   */
  public get username(): string {
    return this._username;
  }

  /**
   * Getter password
   * @return {string }
   */
  public get password(): string {
    return this._password;
  }

  /**
   * Getter role
   * @return {Role }
   */
  public get role(): Role {
    return this._role;
  }

  /**
   * Getter mail
   * @return {string }
   */
  public get mail(): string {
    return this._mail;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number) {
    this._id = value;
  }

  /**
   * Setter username
   * @param {string } value
   */
  public set username(value: string) {
    this._username = value;
  }

  /**
   * Setter password
   * @param {string } value
   */
  public set password(value: string) {
    this._password = value;
  }

  /**
   * Setter role
   * @param {Role } value
   */
  public set role(value: Role) {
    this._role = value;
  }

  /**
   * Setter mail
   * @param {string } value
   */
  public set mail(value: string) {
    this._mail = value;
  }
}
