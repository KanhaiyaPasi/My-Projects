let searchbtn = document.querySelector("#searchbtn");
let usernameinp = document.querySelector("#usernameinp");
let card = document.querySelector("#profile-card");
let repoSection = document.querySelector("#repo-section");
let toggle = document.querySelector("#theme-toggle");

function getProfileData(username) {
  return fetch(`https://api.github.com/users/${username}`).then((raw) => {
    if (!raw.ok) throw new Error("User not found.");
    return raw.json();
  });
}

function getRepos(username) {
  return fetch(`https://api.github.com/users/${username}/repos?sort=updated`)
    .then((raw) => {
      if (!raw.ok) throw new Error("failed to fetch repos...");
      return raw.json();
    });
}

function decorateProfileData(details) {
  card.style.display = "flex";
  let data = `
    <div class="left">
      <img src="${details.avatar_url}" alt="GitHub Profile" class="avatar"/>
    </div>
    <div class="right">
      <h2 class="username">${details.login}</h2>
      <div class="row">
        <p><strong>Name:</strong> ${details.name || "N/A"}</p>
        <p><strong>Repos:</strong> ${details.public_repos}</p>
      </div>
      <div class="row">
        <p><strong>Followers:</strong> ${details.followers}</p>
        <p><strong>Following:</strong> ${details.following}</p>
      </div>
      <div class="row">
        <p><strong>Location:</strong> ${details.location || "N/A"}</p>
        <p><strong>Company:</strong> ${details.company || "N/A"}</p>
      </div>
      <div class="row">
        <p><strong>Blog:</strong> <a href="${details.blog}" target="_blank">${details.blog || "N/A"}</a></p>
      </div>
      <div class="row">
        <p><strong>Bio:</strong> ${details.bio || ""}</p>
      </div>
    </div>`;
  card.innerHTML = data;
}

function displayRepos(repos) {
  if (!repos || !repos.length) return;
  repoSection.style.display = "block";
  repoSection.innerHTML = `<h3>Latest Repositories:</h3>
    <ul>
      ${repos.slice(0, 5).map(repo => `<li><a href="${repo.html_url}" target="_blank">${repo.name}</a></li>`).join('')}
    </ul>`;
}

function showError(msg) {
  card.style.display = "flex";
  card.innerHTML = `<p style="animation: blink 0.8s infinite alternate; color: red; font-size: 1.2rem;">${msg}</p>`;
  repoSection.style.display = "none";
}

function searchUser() {
  let username = usernameinp.value.trim();
  if (username.length > 0) {
    getProfileData(username)
      .then((data) => {
        decorateProfileData(data);
        return getRepos(username);
      })
      .then((repos) => displayRepos(repos))
      .catch(() => showError("User not found ❌"));
  } else {
    showError("Username cannot be empty ⚠️");
  }
}

searchbtn.addEventListener("click", searchUser);
usernameinp.addEventListener("keydown", (e) => {
  if (e.key === "Enter") searchUser();
});

toggle.addEventListener("change", () => {
  document.body.classList.toggle("light-mode");
});
