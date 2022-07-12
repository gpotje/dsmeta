import icon from '../../assets/img/notificantion-icon.svg';
import './styles.css';

function NoticationButton() {
   return (
   <>
    <div className="dsmeta-red-btn"> 
        <img src={icon} alt="Notificar" />
    </div>
   </>
    )
  }
  
  export default NoticationButton;
  