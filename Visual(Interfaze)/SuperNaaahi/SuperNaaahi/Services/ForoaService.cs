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
    /// Foroaren informazioa kudeatzeko
    /// </summary>
    public class ForoaService : IForoaService
        
    {
 
        private readonly SuperNaaahiDbContext _superNaaahiDbContext;

        /// <summary>
        /// ForoaService knstruktorea
        /// </summary>
        /// <param name="superNaaahiDbContext"></param>
        public ForoaService(SuperNaaahiDbContext superNaaahiDbContext)
        {
            _superNaaahiDbContext = superNaaahiDbContext;
        }

        /// <summary>
        /// sql serverra gehitu foroa
        /// </summary>
        /// <param name="f"></param>
        /// <returns></returns>
        public async Task Komentatu(Foroa f)
        {
            _superNaaahiDbContext.Foroa.Add(f);
            _superNaaahiDbContext.SaveChanges();

        }

        /// <summary>
        /// SQL Serverretik komentarioak lortu gero aldatu ahal izateko
        /// </summary>
        /// <returns>Komentarioen lista itzuli</returns>
        public async Task<IList<Foroa>> KomentarioakLortu()
        {
            return await _superNaaahiDbContext.Foroa.ToListAsync();
        }
    }
}
