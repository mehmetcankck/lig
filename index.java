function updateTable() {
  const tbody = document.getElementById("tableBody");
  tbody.innerHTML = '';

  // Sıralama: önce puana göre, eşitse averaja göre
  const sorted = players.slice().sort((a, b) => {
    const aStats = stats[a];
    const bStats = stats[b];
    const aPoints = aStats.G * 3 + aStats.B;
    const bPoints = bStats.G * 3 + bStats.B;
    const aAvg = aStats.AG - aStats.YG;
    const bAvg = bStats.AG - bStats.YG;

    if (bPoints !== aPoints) return bPoints - aPoints;
    return bAvg - aAvg;
  });

  // Tabloyu sıraya göre yaz
  sorted.forEach(p => {
    let s = stats[p];
    let AV = s.AG - s.YG;
    let P = s.G * 3 + s.B;
    tbody.innerHTML += `
      <tr>
        <td>${p}</td>
        <td>${s.O}</td>
        <td>${s.G}</td>
        <td>${s.B}</td>
        <td>${s.M}</td>
        <td>${s.AG}</td>
        <td>${s.YG}</td>
        <td>${AV}</td>
        <td>${P}</td>
      </tr>
    `;
  });
}
