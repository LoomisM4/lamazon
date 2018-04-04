<form method="post">
    <div class="form-group" style="text-align: center;">
        <h3>Neue Nachricht</h3>
    </div>
    <style type="text/css">
        .line {
            border-radius: 10px;
            background-color: lightblue;
            width: 100%;
            height: 15%
        }
        .box {
            border-radius: 10px;
            border-color: lightblue;
            border-width: 10px;
            border-top: lightblue 10px solid;
            border-bottom: lightblue 5px solid;
            border-style: solid;
        }
        .abstand {
            margin-top: 2%;
        }

    </style>
    <div class="form-group">
        <div class="line">
            <div class="box"><label><b>Empf&auml;nger:</b></label>  ${article.getUser().getBenutzername()}</div>
            <div class="box"><label><b>Absender:</b></label> ${user.getBenutzername()}</div>
            <div class="box"><input type="text" class="form-control form-control-sm" placeholder="Betreff" name="betreff"></div>
        </div>
        <br>
        <div class="abstand">
            <input type="text" class="form-control form-control-sm" placeholder="Nachricht" name="nachricht">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Senden</button>
</form>