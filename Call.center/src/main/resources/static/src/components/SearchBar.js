import { useState } from "react";

const SearchBar = ({ callWhenSubmit }) => {
  const [inputValue, setInputValue] = useState("");


  const handleInput = (event) => {
    setInputValue(event.target.value);
    console.log(inputValue);
  };
  const handleFormSubmit = (event) => {
  event.preventDefault();
  console.log("SearchBar dice " + inputValue);
  callWhenSubmit(inputValue);
  };
  return (
    <nav className="navbar bg-dark mt-3">
      <div className="container-fluid">
        <a className="navbar-brand  text-light">Navbar</a>
        <form className="d-flex" role="search" onSubmit={handleFormSubmit}>
          <input
            className="form-control me-2"
            type="search"
            placeholder="Search"
            aria-label="Search"
            onChange={handleInput}
            value={inputValue}
          />
          <button className="btn btn-outline-success" type="submit">
            Search
          </button>
        </form>
      </div>
    </nav>
  );
};

export{SearchBar}