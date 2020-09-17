import { Badge } from './badge';
import { Children } from './children';
import { Attributes } from './attributes';

export class Nawigation{
    public name :string;
    public url :string;
    public icon :string;
    public badge :Badge;
    public children = new Array<Children>();
    public attributes = new Array<Attributes>();
    public sequence: string;
    public navigationId : string;

}