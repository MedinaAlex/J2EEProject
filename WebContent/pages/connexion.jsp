<<<<<<< HEAD
<h1>form</h1>
<<<<<<< HEAD
=======
<a href="/fr.epsi.network/pages/register.jsp">Inscription</a>
=======
<br>
>>>>>>> 521e36d229a5c7100c01a84eedfc730cfae0f90a
>>>>>>> ebcc1f9e21ce4406623827808b13532f46ed98d9
<form method="post" action="connexion">
    <fieldset>
        <legend>Connexion</legend>
        <p>Saisissez votre ID et votre mot de passe</p>

        <label for="id">Adresse email <span class="requis">*</span></label>
        <input type="text" id="id" name="id" size="20" maxlength="60" />
        <span class="erreur">${form.erreurs['id']}</span>
        <br />

        <label for="password">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="password" name="password" value="" size="20" maxlength="255" />
        <span class="erreur">${form.erreurs['password']}</span>
        <br />

        <input type="submit" value="Connexion" class="sansLabel" />
        <br />
        
        <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
    </fieldset>
</form>