import axios from 'axios';
import { toast } from 'react-toastify';
import icon from '../../assets/img/notificantion-icon.svg';
import { BASE_URL } from '../../utils/request';
import './styles.css';

type Props = {
  saleId:number;
}

function handleClick(id: number){
  axios(`${BASE_URL}/sales/${id}/notification`)
    .then(reponse => {
      toast.info(reponse.data)
    })
}

function NoticationButton({saleId}: Props) {
   return (
   <>
    <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}> 
        <img src={icon} alt="Notificar" />
    </div>
   </>
    )
  }
  
  export default NoticationButton;
  