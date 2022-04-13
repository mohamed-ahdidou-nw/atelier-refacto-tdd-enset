## Bonjour Je m'appelle Mohamed AHRRASS

# solution de Refactoring
L'utilistation de design Pattern `Strategy` sera une solution benefique

On va avoir une interface `IUpdate` ou on a la methode update qui va etre implemente selon le type d item

`Context` une Classe qui va associer entre chaque item et son propre Comportement
`Item` classe sans aucune modification

# l'ajout d'une nouvelle fonctionalite "Conjured"

Quand on veut ajouter le traitement d'un autre Item
il suffit d'ajouter la Classe `Conjured implements IUpdate` apres on manipule la methode update selon le genre de traitement


<img src="https://res.cloudinary.com/drmmqpbsw/image/upload/v1649275096/img_rtjuim.png" width="1000"/>
