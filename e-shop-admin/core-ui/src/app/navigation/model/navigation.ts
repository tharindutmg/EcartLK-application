import { Children } from '../../containers/default-layout/model/children';
import { Badge } from '../../containers/default-layout/model/badge';
import { Attributes } from '../../containers/default-layout/model/attributes';

export class Navidation{
    public name :string;
    public url :string;
    public icon :string;
    public badge :Badge;
    public children :Children[];
    public attributes :Attributes;
    public sequence :string;
    public navigationId: string;
    

	
}