<form method="post">
    <div class="form-group" style="text-align: center;">
        <h3>Neue Nachricht</h3>
    </div>
    <style type="text/css">
        .line {
            border-radius: 10px;
            background-color: lightblue;
            width: 100%;
            min-height: 18%;
            border-color: lightblue;
            border-width: 10px;
            border-top: lightblue 10px solid;
            border-bottom: lightblue 8px solid;
            border-style: solid;

        }

        .abstand {
            margin-top: 2%;
        }

    </style>
    <div class="form-group line">

        <div><label><b>Empf&auml;nger:</b></label>  ${article.getUser().getBenutzername()}</div>
        <div><label><b>Absender:</b></label>   ${user}</div>
        <div><input type="text" class="form-control form-control-sm" placeholder="Betreff" name="betreff"></div>

        <input type="text" class="form-control form-control-sm abstand" placeholder="Nachricht" name="nachricht">

    </div>
    <div>
        <button  type="submit" class="btn btn-primary">Senden</button>
    </div>
</form>