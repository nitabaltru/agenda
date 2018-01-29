# Agenda Inc <img src="/src/images/logo.jpg" /> 

Cette application multi-agenda fait partie d'un projet Java pour l'université.
Il permet aux utilisateurs d'avoir plusieurs agenda dans une seule application, en utilisant des fichiers "Properties".

<img src="/src/images/screenshot.png"/>

## Fonctionnalités principales

- Les exceptions ont été capturées et traitées pour éviter que l'application s'arrête de façon inattendue.
- Tout le code (package, classes et méthodes) est documenté. La javadoc a été générée pour une visibilité privée (doc_private) et pour une visibilité publique (doc).
- L'application a une interface graphique créée en utilisant javax.swing
- L'application a un menu permettant d'ouvrir un autre agenda, créer un nouvel agenda, enregistrer l'agenda sous un répertoire choisi par l'utilisateur, quitter l'application. Mais aussi choisir la langue de l'application.
- Tous les évènements sont gérés en utilisant des classes internes anonymes.
- Le code de l'application est divisé en package permettant de séparer la structure de façon logique.
- Chaque agenda est sauvegardé sous la forme d'un fichier Properties.
- L'internationalisation de l'application est réalisée en utilisant les classes java.util.Locale et java.util.ResourceBundle en plus des fichiers Properties.
- La clase java.util.prefs.Preferences est utilisée pour stocker le chemin de l'agenda qui est ouverte et la langue choisi par l'utilisateur.

## Auteur

[Diana Baltrusaitis](https://github.com/nitabaltru)
