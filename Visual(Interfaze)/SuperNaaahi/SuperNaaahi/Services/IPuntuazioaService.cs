using SuperNaaahi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Services
{
    /// <summary>
    /// PuntuazioService interfazea
    /// </summary>
    public interface IPuntuazioaService
    {
   
        /// <summary>
        /// Puntuazio guztiak kudeatu
        /// </summary>
        /// <returns> Puntuazio guztien lista</returns>
        Task<List<PuntuazioaModel>> GetPuntuazioak();

        /// <summary>
        /// Puntuazio onenak kudeatu
        /// </summary>
        /// <returns>Puntuazio onenen lista </returns>
        Task<List<PuntuazioaModel>> GetHallOfFame();
        /// <summary>
        /// Puntuazio txarrenak kudeatu
        /// </summary>
        /// <returns>Puntuazio txarrenen lista </returns>
        Task<List<PuntuazioaModel>> GetHallOfShame();
        /// <summary>
        /// Rest-apitik 5 puntuazio jaso
        /// </summary>
        /// <returns>5 puntuazio dauden lista </returns>
        Task<List<PuntuazioaModel>> GetBostPuntuazio();
        /// <summary>
        /// Rest-apitik 10 puntuazio kudeatu
        /// </summary>
        /// <returns>10 puntuazio dauden lista</returns>
        Task<List<PuntuazioaModel>> GetHamarPuntuazio();
        /// <summary>
        /// Rest-apitik 15 puntuazio kudeatu
        /// </summary>
        /// <returns>15 puntuazio dauden lista </returns>
        Task<List<PuntuazioaModel>> GetHamabostPuntuazio();
   


    }
}
