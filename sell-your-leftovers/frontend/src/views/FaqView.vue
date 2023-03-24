<template>
  <div class="container">
    <div class="row">
      <p class="center display-4">Wir sorgen uns um die Fragen der Community...</p>
      <p class="center display-6 text-muted pb-4">Daher hier alle FAQs im Überblick:</p>
    </div>
    <div class="row">
      <div class="accordion" id="accordionExample">
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingOne">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
              <strong>Wie hoch sind die Lieferkosten?</strong>
            </button>
          </h2>
          <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne"
               data-bs-parent="#accordionExample">
            <div class="accordion-body">
              Die Lieferkosten betragen 0 Euro weltweit und es gibt keinen Mindesteinkaufswert!
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingTwo">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
              <strong>Was darf man alles verkaufen?</strong>
            </button>
          </h2>
          <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo"
               data-bs-parent="#accordionExample">
            <div class="accordion-body">
              Verkauft werden dürfen noch nicht geöffnete und noch haltbare Getränke jeglicher Art.
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseThree">
              <strong>Was darf man nicht verkaufen?</strong>
            </button>
          </h2>
          <div id="collapseFive" class="accordion-collapse collapse" aria-labelledby="headingThree"
               data-bs-parent="#accordionExample">
            <div class="accordion-body">
              Nicht verkauft werden dürfen Getränke, die bereits abgelaufen sind oder sonstige Mängel aufweisen.
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingThree">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
              <strong>Wie lange dauert normalerweise der Prozess von der Bestellung bishin zur
                Auslieferung?</strong>
            </button>
          </h2>
          <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree"
               data-bs-parent="#accordionExample">
            <div class="accordion-body">
              Der Versand variiert je nach Kontinent zwischen 3-10 Werktage.
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseThree">
              <strong>Wie entstand die Idee für Sell Your Leftovers?</strong>
            </button>
          </h2>
          <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingThree"
               data-bs-parent="#accordionExample">
            <div class="accordion-body">
              Die Idee für die Plattform Sell Your Leftovers entstand im Rahmen des Wahlpflichtmoduls Business Process Application Programming an der Technischen Hochschule Augsburg. Ziel der Plattform ist es eine Lösung für das Problem der übrig bleibenden Getränke nach Feiern jeglicher Art zu finden. So entstand die Idee der Plattform.
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseThree">
              <strong>Wie viele Produkte wurden bis jetzt verkauft</strong>
            </button>
          </h2>
          <div id="collapseSix" class="accordion-collapse collapse" aria-labelledby="headingThree"
               data-bs-parent="#accordionExample">
            <div class="accordion-body">
              Im ersten Monat waren es bereits 1000 Liter.
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "FaqView"
}
</script>

