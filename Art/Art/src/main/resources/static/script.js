const contentElemento = document.getElementById("content");

const submitBtn = document.getElementById("btId");
const nameInput = document.getElementById("name");
const cityInput = document.getElementById("city");
const countryInput = document.getElementById("country");
const idInput = document.getElementById("id");
const clearBtn = document.getElementById("btnclear")

const ART_URL = "http://localhost:8080/api/v1/museums";


clearBtn.addEventListener("click", (event) => {
  event.preventDefault();
  clearInput();
});

// METODI GETTER per prendere le entity e le relazioni associate

// GET LIST MUSEUM
const getListMuseum = (data) => {
  let content = `<div class="container mt-5">
  <div class="row">`;
  data.forEach((element) => {
    content += renderMuseum(element);
  });

  // DELETE MUSEUM BY BUTTON
  content += "</div></div>";
  contentElemento.innerHTML = content;
  const deleteButtonMuseum = document.querySelectorAll("[data-id]");
  deleteButtonMuseum.forEach((el) => {
    console.log(el);
    el.addEventListener("click", (event) => {
      event.preventDefault();
      deleteMuseum(event.target);
    });
  });

  /// UPDATE MUSEUM BY BUTTON
  const updateButtonMuseum = document.querySelectorAll("[data-up]");
  updateButtonMuseum.forEach((el) => {
    console.log(el);
    let idForElement = el.dataset.up;
    el.addEventListener("click", (event) => {
      event.preventDefault();
      idInput.value = idForElement;
      nameInput.value = el.dataset.name;
      cityInput.value = el.dataset.city;
      countryInput.value = el.dataset.country;
    });
  });
};


// prendiamo le opere collegate ai musei
let getlistArtworks = (artworks) => {
  let content = `<div class="list-artworks">`;
  artworks.forEach((element) => {
    content += renderArtworks(element);
  });
  content += "</div>";
  return content;
};

// prendiamo gli artisti collegati alle opere
const getArtist = (artist) => {
  let content = `<div>------<p>ARTIST</p>
  <span>- ${artist.firstName} ${artist.lastName} ${artist.country}</span>
  </div>`;
  return content;
};

// prendiamo la lista dei personaggi collegati alle opere
const getListCharacters = (characters) => {
  let content = `<div>------<p>CHARACTERS</p>`;
  characters.forEach((element) => {
    content += renderCharacter(element);
  });
  content += "</div><hr>";
  return content;
};

// STRUTTURA HTML PER LA CREAZIONE DELLE CARDS

// CREA LISTA MUSEUMS
const renderMuseum = (museum) => {
  const li = `
  <div class="card col-12 col-md-6 col-lg-3 mb-3 ms-3 p-2" style="width: 18rem">
  <img class="img-thumbnail"
    style="height: 200px;"
    src="${museum.img}"
    class="card-img-top"
  />
  <div class="card-body">
    <h3 class="card-title">${museum.name}</h3>

    <p class="card-text">${getlistArtworks(museum.artworks)}</p>
  </div>
  <a
    class="btn btn-danger btn-sm"
    data-id="${museum.id}"
    >&cross;</a
  >
  <a
    class="btn btn-primary btn-sm"
    data-up="${museum.id}"
    data-name="${museum.name}"
    data-city="${museum.city}"
    data-country="${museum.country}"
  ><i class="fa-solid fa-pen"></i>
  </a>
  </div>`;

  return li;
};

// CREA LISTA ARTWORK

const renderArtworks = (artwork) => {
  const li = [
    `
    <div class="container">
      <div class="row">
        <div class="btn-group">
          <button
            class="btn btn-dropdown btn-sm dropdown-toggle"
            type="button"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            ${artwork.title}
          </button>
          <ul class="dropdown-menu">
            <div>
              <p>ARTWORKS</p>
              <span>- ${artwork.title}</span>` +
              getArtist(artwork.artist) +
              getListCharacters(artwork.characters) +
      `
            </div>
          </ul>
        </div>
      </div>
    </div>
`,
  ];
  return li;
};

// CREA LISTA CHARACTERS

const renderCharacter = (characters) => {
  const li = `
  <div>
  <span>- ${characters.name}</span>
  </div>`;
  return li;
};





/** FUNZIONI REST MUSEUM */

// Function GET
const getMuseum = async () => {
  try {
    const respons = await fetch(ART_URL);
    console.log(respons);
    if (respons.ok) {
      const data = await respons.json();
      getListMuseum(data);
    } else {
      console.log(respons.status);
    }
  } catch (error) {
    console.log(error);
  }
};


//Functiuon delete

const deleteMuseum = async (element) => {
  const museumId = element.dataset.id; // leggo il data attribute dell'ancora
  const response = await fetch(ART_URL + "/" + museumId, {
    method: "DELETE",
  });
  if (response.ok) {
    getMuseum();
  }
};

// function di update
const updateMuseum = async () => {
  const id = idInput.value;
  const name = nameInput.value;
  let city = cityInput.value;
  let country = countryInput.value;
  const body = { id: id, name: name, city: city, country: country };
  console.log(body);
  try {
    const response = await fetch(ART_URL + "/" + id + "/" + "update", {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    });
    if (response.ok) {
      getMuseum();
    } else {
      console.log(response.status);
    }
  } catch (error) {
    console.log(error);
  }
};

// fare una post per creare un nuovo Museum
const postMuseum = async () => {
  // leggo i valori degli input dal DOM
  const name = nameInput.value;
  let city = cityInput.value;
  let country = countryInput.value;
  // costruisco il body della request
  const body = { name: name, city: city, country: country };
  console.log(body);
  // invio la request
  try {
    const response = await fetch(ART_URL + "/newmus", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    });
    console.log(response);
    if (response.ok) {
      // la post ha avuto successo, ricarico il museo
      console.log("ok");
      getMuseum();
      clearInput();
    } else {
      // gestire i vari errori in base a http status e messaggi
      console.log(response.status);
    }
  } catch (error) {
    console.log(error);
  }
};


/// SVUOTA CAMPI
const clearInput = ()=>{
  idInput.value = "";
  nameInput.value = "";
  cityInput.value = "";
  countryInput.value = "";
}



/******START APP */

submitBtn.addEventListener("click", (event) => {
  event.preventDefault();
  if (idInput.value == 0) {
    postMuseum();

  } else {
    updateMuseum();
  }
  getMuseum();
  clearInput();
});

getMuseum();
