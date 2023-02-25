import Image from "./img/images.jpg";
import { CallPhoneList } from "./CallPhoneList";
import { useState } from "react";

const Subscriber = ({ item, onDelete }) => {

const [createSub, setCreateSub] = useState(false);

const handleDeleteSubscriber=()=>{
  const answer = window.confirm('Confirm delete?');
    if (answer) onDelete(item.id);
}

  return (
    <div
      className="card border border-0 shadow p-3 bg-body rounded "
      style={{ width: "18rem", height: "40rem" }}
    >
      <img src={Image} className="card-img-top circular-square" alt="Foto" />
      <div className="card-body  ">
        <h5 className="card-title">
          {item.firstname} {item.lastname}
        </h5>
        <ul className="list-group  ">
          <li className="list-group-item list-group-item-info">Id:{item.id}</li>

          <li className="list-group-item">Dob:{item.dob}</li>
          <li className="list-group-item">City:{item.cityofbirth}</li>
          <li className="list-group-item">Credito: {item.cretid}</li>
          <li className="list-group-item dropdown">
            <CallPhoneList data={item.phoneCallSet} />
          </li>
        </ul>

        <button className=" bg-primary" onClick={handleDeleteSubscriber}>
          <i className="fa fa-trash" aria-hidden="true"></i>
        </button>
      </div>
    </div>
  );
};
export { Subscriber };
