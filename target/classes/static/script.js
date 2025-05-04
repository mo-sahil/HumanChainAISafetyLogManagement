// src/main/resources/static/script.js
const apiBase = "http://localhost:8080/incidents";

document.addEventListener("DOMContentLoaded", () => {
  loadIncidents();

  document.getElementById("incidentForm").addEventListener("submit", async (e) => {
    e.preventDefault();
    const title = document.getElementById("title").value;
    const description = document.getElementById("description").value;
    const severity = document.getElementById("severity").value;

    const response = await fetch(apiBase, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ title, description, severity })
    });

    if (response.ok) {
      document.getElementById("incidentForm").reset();
      loadIncidents();
    } else {
      alert("Failed to report incident.");
    }
  });
});

async function loadIncidents() {
  const list = document.getElementById("incidentList");
  list.innerHTML = "";
  try {
    const res = await fetch(apiBase);
    const data = await res.json();
    data.forEach((incident) => {
      const div = document.createElement("div");
      div.className = "incident";
      div.innerHTML = `
        <h3>${incident.title}</h3>
        <p>${incident.description}</p>
        <p><strong>Severity:</strong> ${incident.severity}</p>
        <p><strong>Reported At:</strong> ${new Date(incident.reportedAt).toLocaleString()}</p>
        <button class="delete-btn" onclick="deleteIncident('${incident.id}')">Delete</button>
      `;
      list.appendChild(div);
    });
  } catch (err) {
    list.innerHTML = "<p>Error loading incidents.</p>";
  }
}

async function deleteIncident(id) {
  const res = await fetch(`${apiBase}/${id}`, { method: "DELETE" });
  if (res.ok) {
    loadIncidents();
  } else {
    alert("Failed to delete incident.");
  }
}
