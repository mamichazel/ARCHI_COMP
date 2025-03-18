function openFlightDetailsModal(button) {
    let flightId = button.getAttribute("data-flight-id");
    let numeroVol = button.getAttribute("data-numero-vol");
    let compagnie = button.getAttribute("data-compagnie");
    let modele = button.getAttribute("data-modele");
    let depart = button.getAttribute("data-depart");
    let arrivee = button.getAttribute("data-arrivee");
    let statut = button.getAttribute("data-statut");

    document.getElementById("modalNumeroVol").textContent = numeroVol;
    document.getElementById("modalCompagnie").textContent = compagnie;
    document.getElementById("modalModele").textContent = modele;
    document.getElementById("modalDepart").textContent = depart;
    document.getElementById("modalArrivee").textContent = arrivee;
    document.getElementById("modalStatut").textContent = statut;

    let passengerListBtn = document.getElementById("passengerListBtn");
    passengerListBtn.setAttribute("href", "/flights/" + flightId + "/passengers");

    let modal = new bootstrap.Modal(document.getElementById("flightDetailsModal"));
    modal.show();
}
