using Microsoft.EntityFrameworkCore;
using SuperNaaahi.Data;
using SuperNaaahi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Services
{
    /// <summary>
    /// Inkestaren informazioa kudeatzeko
    /// </summary>
    public class InkestaService : IInkestaService
    {
        private readonly SuperNaaahiDbContext _superNaaahiDbContext;

        /// <summary>
        /// InkestaService konstruktorea
        /// </summary>
        /// <param name="superNaaahiDbContext"></param>
        public InkestaService(SuperNaaahiDbContext superNaaahiDbContext)
        {
            _superNaaahiDbContext = superNaaahiDbContext;
        }

        /// <summary>
        /// SQL Serverren inkesta gorde
        /// </summary>
        /// <param name="i"></param>
        /// <returns></returns>
        public async Task InkestaBete(Inkesta i)
        {
            try
            {
         
                _superNaaahiDbContext.Inkesta.Add(i);
                _superNaaahiDbContext.SaveChanges();
            }
            catch(Exception ex)
            {
            }
        }
        /// <summary>
        /// Konprobatzea inkesta egin duen emaila
        /// </summary>
        /// <param name="korreoa"></param>
        /// <returns>Email hori daukan inkesta itzuli</returns>
        public async Task<Inkesta> KonprobatuKorreoa(string korreoa)
        {
            var inkesta = await _superNaaahiDbContext.Inkesta.SingleOrDefaultAsync(i => i.Korreoa == korreoa);
            return inkesta;
            
        }
        /// <summary>
        /// Inkestako datuak aldatu
        /// </summary>
        /// <param name="inkesta"></param>
        /// <returns></returns>
        public async Task InkestaAldatu(Inkesta inkesta)
        {
            var inkestaEginda = await _superNaaahiDbContext.Inkesta.SingleOrDefaultAsync(i => i.Korreoa == inkesta.Korreoa);
            inkestaEginda.Balorazioa = inkesta.Balorazioa;
            inkestaEginda.Hobetzeko = inkesta.Hobetzeko;
            inkestaEginda.Gomendatu = inkesta.Gomendatu;

            _superNaaahiDbContext.SaveChanges();
        }
    }
}
