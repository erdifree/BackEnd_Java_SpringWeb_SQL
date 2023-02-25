import { useState } from "react";

import { ModalPutBreeds } from "./Modal";

const SearchBar = ({ callWhenSubmit }) => {
  const [inputValue, setInputValue] = useState("");

  const handleInputChange = (event) => {
    setInputValue(event.target.value);
  };

  const handleFormSubmit = (event) => {
    event.preventDefault();
    console.log("SearchBar dice " + inputValue);
    callWhenSubmit(inputValue);
  };
  return (
    <nav className="navbar bg-dark">
      <div className="container-fluid">
        <a className="navbar-brand text-light">
          <i className="fa-sharp fa-solid fa-bone"></i>Dog Breed
        </a>

       <ModalPutBreeds/>

      
        <form onSubmit={handleFormSubmit}>
          <div className="input-group">
            <input
              type="text"
              className="form-control"
              placeholder="search"
              onChange={handleInputChange}
              value={inputValue}
            ></input>
            <button type="submit" className="btn btn-primary">
              Send
            </button>
          </div>
        </form>
      </div>
    </nav>
  );
};

export default SearchBar;
